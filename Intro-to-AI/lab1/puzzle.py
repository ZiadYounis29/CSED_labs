
from collections import deque
import heapq

moves = ["up","left","down","right"]
board = [1,4,2,6,7,5,8,0,3]
goal = [0,1,2,3,4,5,6,7,8]

def applyMove(board ,move):
    board = board.copy()
    index = board.index(0)
    
    if move == "up" and index > 2:
        board[index] , board[index-3] = board[index-3] ,board[index]
        
    elif move == "left" and index%3 >0:
        board[index] , board[index-1] = board[index-1] ,board[index]
        
    elif move == "down" and index < 6:
        board[index] , board[index+3] = board[index+3] ,board[index]
            
    elif move == "right" and index%3 <2:
        board[index] , board[index+1] = board[index+1] ,board[index]
    
    return board
        

def dfs(board , goal, moves):
    frontier = [board]
    visited = {tuple(board)}
    path ={tuple(board) : None}
    
    while board != goal:
        board = frontier.pop()
        
        for move in moves:
            current = applyMove(board , move)
            if tuple(current) not in visited:
                frontier.append(current)
                visited.add(tuple(current))
                path[tuple(current)] = tuple(board)
                    
    return board, path

def bfs(board , goal, moves):
    frontier = deque([board])
    visited = {tuple(board)}
    path = {tuple(board) : None}
    
    while board != goal:
        board = frontier.pop()
        
        for move in moves:
            current = applyMove(board , move)
            
            if tuple(current) not in visited:
                frontier.appendleft(current)
                visited.add(tuple(current))
                
                if tuple(current) not in path:
                    path[tuple(current)] = tuple(board)
            
    return board, path


def limitedDfs(board , goal, moves,maxDepth):
    frontier = [(board,0)]
    visited = {tuple(board) : 0}
    path = {tuple(board) : None}
    
    while board != goal and len(frontier) !=0:
        board ,depth = frontier.pop()
        if depth < maxDepth:    
            for move in moves:
                current = applyMove(board , move)
                
                if tuple(current) not in visited or depth+1 < visited[tuple(current)]:
                    frontier.append((current , depth +1))
                    visited[tuple(current)] = depth +1
                    path[tuple(current)] = tuple(board)
        
    if board == goal:
        return board, path
    else:
        return None ,None
    
    
def idfs(board, goal, moves):
    maxDepth = 0
    newBoard = board
    while newBoard != goal:
        newBoard ,path = limitedDfs(board, goal, moves, maxDepth)
        maxDepth += 1
    return newBoard, path

def hueristicManhattan(board):
    total = 0
    for i in range(8):
        index = board.index(i)
        y = abs(i//3 - index//3)
        x = abs(i%3 - index%3)
        total += x + y
    return total

def hueristicEuclidean(board):
    total = 0
    for i in range(8):
        index = board.index(i)
        y = abs(i//3 - index//3)
        x = abs(i%3 - index%3)
        total += (x**2 + y**2)**0.5
    return total

def Astar(board, goal, moves,hueristic):
    frontier = []
    f_score =hueristic(board)
    order = 0
    heapq.heappush(frontier,(f_score, order, board))
    visited = {tuple(board):0}
    path = {tuple(board) :None}
    
    while board != goal:
        f_score,_,board = heapq.heappop(frontier)
        g = visited[tuple(board)]
        
        if f_score > g + hueristic(board):
            continue
                
        for move in moves:
            current = applyMove(board, move)
            
            if tuple(current) not in visited or (visited[tuple(current)] > g+1):
                order +=1
                f_score = g+1 +hueristic(current)
                visited[tuple(current)] = g+1
                heapq.heappush(frontier,(f_score,order,current))
                path[tuple(current)] = tuple(board)
        
    return board ,path
                
                
def getSolution(path ,goal):
    current = tuple(goal)
    solution = [current]
    while path[current] != None:
        current = path[current]
        solution.append(current)
    return solution[::-1]

def isValid(board):
    inversions = 0
    for i in range(9):
        for j in range(i+1,9):
            if board[i] > board[j] and board[i] != 0 and board[j] != 0:
                inversions +=1
    return inversions%2 == 0
            

            
        
        
