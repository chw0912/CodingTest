from datetime import datetime


def solution(video_len, pos, op_start, op_end, commands):
    video_m, video_s = parseTime(video_len)
    pos_m, pos_s = parseTime(pos)
    op_start_m, op_start_s = parseTime(op_start)
    op_end_m,op_end_s = parseTime(op_end)
    
    pos_m, pos_s = moveTime(op_start_m, op_start_s, op_end_m, op_end_s, pos_m, pos_s)
    for command in commands:
        pos_m, pos_s = commandMove(video_m, video_s, pos_m, pos_s, command)
        pos_m, pos_s = moveTime(op_start_m, op_start_s, op_end_m, op_end_s,pos_m, pos_s)
    
    pos_m = str(pos_m)
    pos_s = str(pos_s)
    if len(pos_m) < 2:
        pos_m = "0" + pos_m
    if len(pos_s) < 2:
        pos_s = "0" + pos_s
    
    
            
    
    return pos_m +":" +pos_s

def commandMove(video_m, video_s, pos_m, pos_s, command):
    video_len = convertSeconds(video_m, video_s)
    pos = convertSeconds(pos_m, pos_s)
    if command == "next":
        pos += 10
        if video_len < pos:
            pos = video_len
    else:
        pos -= 10
        if pos < 0:
            pos = 0
    
    return [pos//60, pos%60]
    
def moveTime(op_start_m, op_start_s, op_end_m, op_end_s, pos_m, pos_s):
    op_start = convertSeconds(op_start_m, op_start_s)
    pos = convertSeconds(pos_m, pos_s)
    op_end = convertSeconds(op_end_m, op_end_s)
    m,s = pos_m, pos_s
    
    if op_start <= pos <= op_end:
        m = op_end_m
        s = op_end_s
    return [m, s]
    

def convertSeconds(m, s):
    return m * 60 + s

def parseTime(time):
    t = time.split(":")
    m = int(t[0])
    s = int(t[1])
    return [m, s]