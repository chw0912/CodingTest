def solution(data, ext, val_ext, sort_by):
    answer = [[]]
    data_type = {"code" : 0, "date" : 1, "maximum" : 2, "remain" : 3}
    filtered_data = [d for d in data if d[data_type[ext]] < val_ext]

    sorted_filtered_data = sorted(filtered_data, key=lambda x:x[data_type[sort_by]])
    return sorted_filtered_data