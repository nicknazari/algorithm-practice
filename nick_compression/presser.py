import sys

# decide if we are compressing or decompressing
# to compress
# 

# parsing args
args = sys.argv
operation = args[1]

valid_args = ['c','d']

if operation not in valid_args:
	raise SyntaxError(operation + " is not a valid operation")

filename = args[2]


