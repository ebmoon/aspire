from utils import *

if __name__ == "__main__":
    result_path = "./result/"
    inc_logic = merge_tables("",
                             result_path + "IncLogic.csv")
    concurrency = merge_tables(result_path + "ConcurrencyOver.csv",
                               result_path + "ConcurrencyUnder.csv")
    game = merge_tables(result_path + "GameOver.csv",
                        result_path + "GameUnder.csv")
    output = concat_csv_data([inc_logic, concurrency, game])
    write_csv_rows(output, result_path + "table1.csv")
