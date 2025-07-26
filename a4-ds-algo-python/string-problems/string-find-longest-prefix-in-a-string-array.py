
def find_longest_prefix(arr):
	res = arr[0]

	for t in arr[1: len(arr)]:
		print(t)

if __name__ == "__main__":
	strArr = ["flow", "flower","float"]
	find_longest_prefix(strArr)