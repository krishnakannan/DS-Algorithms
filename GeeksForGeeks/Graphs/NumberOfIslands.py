'''Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function would be added by GfG's Online Judge.'''

# your task is to complete this function
# Your function should return an integer

#https://practice.geeksforgeeks.org/problems/find-the-number-of-islands/1

def findIslands(arr, n, m):
	count = 1
	
	for i in range(len(arr)):
		for j in range(len(arr[0])):
			isIslandFound = markGraph(arr, i,j, count)
			if isIslandFound :
				count += 1
	maxIsland = getMin(arr)
	return maxIsland

	

def markGraph(arr, row, col, count):

	#Out of Bounds
	if row < 0 or row >= len(arr) or col < 0 or col >= len(arr[0]):
		return False

	#Already Visited
	if arr[row][col] < 1:
		return False

	#Mark Visited
	arr[row][col] *= -count;

	#Perform DFS # 8 directions
	markGraph(arr, row - 1, col - 1, count);
	markGraph(arr, row - 1, col, count);
	markGraph(arr, row - 1, col + 1, count);
	markGraph(arr, row, col - 1, count);
	markGraph(arr, row, col + 1, count);
	markGraph(arr, row + 1, col - 1, count);
	markGraph(arr, row + 1, col, count);
	markGraph(arr, row + 1, col + 1, count);
	#printMatrix(arr)
	return True

def getMin(arr):
	min = 2500
	for i in range(len(arr)):
		for j in range(len(arr[0])):
			min = arr[i][j] if min > arr[i][j] else min
	return -min

def printMatrix(arr):
	for i in range(len(arr)):
		for j in range(len(arr[0])):
			print(arr[i][j], end='')
		print("\n")