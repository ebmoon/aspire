from utils import *

if __name__ == "__main__":
    result_path = "./result/"
    csv_files = [result_path+"SpyroTest1.csv", result_path+"SpyroTest2.csv",
                 result_path+"SpyroTest3.csv", result_path+"SpyroTest4.csv"]
    output = concat_csv_files_in_memory(csv_files)
    write_csv_rows(output, result_path + "table2.csv")
