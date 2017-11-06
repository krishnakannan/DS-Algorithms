'''Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function would be added by GfG's Online Judge.'''


#Your task is to complete this function
#Function should return an integer denoting the required answer

#http://practice.geeksforgeeks.org/problems/box-stacking/1

def maxHeight(height, width, length, n):
	boxList = [];
	for i in range(n):
		tempList = getBoxOrientation(length[i], width[i], height[i])
		boxList.extend(tempList)
		tempList = []		
		
	sortBoxes(boxList)
	#for i in range(len(boxList)):
	#	print("Area = ", boxList[i].baseArea , " Length = ", boxList[i].length, " Width = ", boxList[i].width , " Height = ", boxList[i].height)
	maxHeight = longestIncreaseingSubsequence(boxList)
	return maxHeight

def longestIncreaseingSubsequence(box):	
	length = len(box)
	heightSeq = [0] * length
	for i in range(length):
		heightSeq[i] = box[i].height		
	maxHeight = 0;
	for i in range(1, length):
		for j in range(0, i):
			if box[i].length < box[j].length and box[i].width < box[j].width:
				if heightSeq[j] + box[i].height > heightSeq[i]:
					heightSeq[i] = heightSeq[j] + box[i].height

	for i in range(length):		
		if maxHeight < heightSeq[i]:
			maxHeight = heightSeq[i]

	return maxHeight

def sortBoxes(box):
	length = len(box)
	for i in range(length):
		for j in range(length):
			if box[i].baseArea < box[j].baseArea and i < j:
				box[i], box[j] = box[j], box[i];				
			elif box[i].baseArea == box[j].baseArea and i < j:
				if box[i].height > box[j].height:
					box[i], box[j] = box[j], box[i];


def getBoxOrientation(length, width, height):
	#print("Processing length = ", length, " width ", width, " height ", height)
	tempList = []
	dimen = [length, width, height]
	dimen.sort(reverse=True)
	tempList.append(Box(dimen[0], dimen[1], dimen[2]))
	tempList.append(Box(dimen[0], dimen[2], dimen[1]))
	tempList.append(Box(dimen[1], dimen[2], dimen[0]))	
	return tempList


class Box:
	def __init__(self, length, width, height):
		self.length = length
		self.width = width
		self.height = height
		self.baseArea = length * width
