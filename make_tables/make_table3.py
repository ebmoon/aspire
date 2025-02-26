from utils import *

if __name__ == "__main__":
    result_path = "./result/"
    merged_data = merge_tables(result_path + "NDTestOver.csv",
                               result_path + "NDTestUnder.csv")
    write_csv_rows(merged_data, result_path + "table3.csv")
