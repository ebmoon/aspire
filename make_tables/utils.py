import csv
import os


import csv
import os


def merge_tables(over_csv_path, under_csv_path):
    """
    Merge two CSV files ('under' and 'over') on (Name, LoC) under these assumptions:
      1) Every (Name, LoC) in 'over' also appears in 'under' (unless over_csv_path is empty).
      2) We want the final CSV rows to appear in the same order as the 'under' file.
      3) If (Name, LoC) is not in 'over', or if over_csv_path is empty, use '/' for Over_#Props, Over_Time.

    Each input CSV must have columns: Name, LoC, #Props, Time.

    This function returns a list-of-lists (like CSV rows in memory):
        [
            ["Name", "LoC", "Over_#Props", "Over_Time", "Under_#Props", "Under_Time"],  # header
            ["rsum", "28", "1", "2161", "1", "2161"],
            ...
        ]
    So you can pass it directly to a function that writes or concatenates CSV data.
    """

    # If under file doesn't exist, return an empty structure and print an error
    if not os.path.isfile(under_csv_path):
        print(f"Error: Under file '{under_csv_path}' does not exist.")
        return []

    # If over_csv_path is specified but doesn't exist, return an empty structure and print an error
    if over_csv_path and not os.path.isfile(over_csv_path):
        print(f"Error: Over file '{over_csv_path}' does not exist.")
        return []

    # 1) Read the 'under' CSV into a list of rows (DictReader) to preserve order
    with open(under_csv_path, mode='r', newline='', encoding='utf-8') as f_under:
        reader_under = csv.DictReader(f_under)
        # store rows so we can iterate in original order
        under_rows = list(reader_under)

    # 2) Build a dictionary for the 'over' data keyed by (Name, LoC)
    over_data = {}
    if over_csv_path:  # if not an empty string
        with open(over_csv_path, mode='r', newline='', encoding='utf-8') as f_over:
            reader_over = csv.DictReader(f_over)
            for row in reader_over:
                name = row['Name']
                loc = row['LoC']
                over_data[(name, loc)] = (row['#Props'], row['Time'])

    # 3) Prepare the merged output in memory
    #    - We'll make the first row the header.
    header = ["Name", "LoC", "Over_#Props",
              "Over_Time", "Under_#Props", "Under_Time"]
    merged_data = [header]

    # 4) Fill data rows
    for row in under_rows:
        name = row['Name']
        loc = row['LoC']
        under_props = row['#Props']
        under_time = row['Time']

        if (name, loc) in over_data:
            over_props, over_time = over_data[(name, loc)]
        else:
            over_props, over_time = '/', '/'

        merged_data.append([
            name,
            loc,
            over_props,
            over_time,
            under_props,
            under_time
        ])

    return merged_data


def concat_csv_data(datasets):
    """
    Concatenate multiple in-memory CSV datasets into a single list of lists.

    Each element in 'datasets' is itself a list of lists (like from merge_tables),
    where the first sub-list is the header row.

    Assumptions:
      1) All datasets share the same header row.
      2) We only want the header row to appear once in the final result.
      3) The columns are in the same order for all datasets.

    Returns:
        A new list of lists, containing the combined rows.
        The first row is the shared header, followed by rows from each dataset.
    """
    # If no datasets are provided, return an empty list
    if not datasets:
        return []

    # Prepare a list to hold the final concatenated data
    concatenated = []

    # Iterate over each dataset
    for i, data in enumerate(datasets):
        # Skip empty datasets
        if not data:
            continue

        if i == 0:
            # For the first dataset, include *all* rows (including the header)
            concatenated.extend(data)
        else:
            # For subsequent datasets, skip the first row (header)
            concatenated.extend(data[1:])

    return concatenated


def concat_csv_files_in_memory(csv_paths):
    """
    Concatenate multiple CSV files that share the same header into one in-memory CSV dataset.

    Args:
        csv_paths (list of str): Paths to CSV files on disk.

    Returns:
        list of lists: A "CSV" in memory. For example:
            [
                ["Name", "LoC", "Over_#Props", "Over_Time"],
                ["foo", "10", "5", "100"],
                ["bar", "15", "3", "60"],
                ...
            ]

    Behavior:
      - Reads each CSV from disk, skipping any that don't exist or are empty.
      - Assumes each CSV has the same header (the very first row).
      - Uses the header from the first valid CSV. For subsequent CSVs:
          * If their header doesn't match exactly, that file is skipped.
      - Only one header row appears in the result.
    """
    all_rows = []        # final list-of-lists
    stored_header = None  # we store the first valid header found

    for path in csv_paths:
        if not path:
            # If the path is empty, skip it
            continue

        if not os.path.isfile(path):
            print(
                f"Warning: File '{path}' does not exist or is not a file. Skipping.")
            continue

        with open(path, mode='r', newline='', encoding='utf-8') as f:
            reader = list(csv.reader(f))
            if not reader:
                print(f"Warning: File '{path}' is empty. Skipping.")
                continue

            # The first row is assumed to be the header
            header = reader[0]
            rows = reader[1:]  # subsequent rows are data

            if stored_header is None:
                # Use this header for the final result
                stored_header = header
                all_rows.append(header)  # add the header row once
            else:
                # Ensure this file's header matches the stored header
                if header != stored_header:
                    print(
                        f"Warning: Header mismatch in '{path}'. Skipping this file.")
                    continue

            # Append data rows
            all_rows.extend(rows)

    return all_rows


def write_csv_rows(rows, output_path):
    with open(output_path, mode='w', newline='', encoding='utf-8') as f:
        writer = csv.writer(f)
        writer.writerows(rows)
