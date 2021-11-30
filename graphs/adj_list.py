graph = []
vertices = 6
for x in range(vertices):
	graph.append([])

def makeedge(g, f, t):
	# g <- graph in which we will make an edge
	# f <- starting node (from)
	# t <- ending node (to)
	graph[f].append(t) if f < len(graph) and t < len(graph) else None

def makeedgeundirected(g, f, t):
	# g <- graph in which we will make an edge
	# f <- starting node (from)
	# t <- ending node (to)
	graph[f].append(t) if f < len(graph) and t < len(graph) else None
	graph[t].append(f) if f < len(graph) and t < len(graph) else None

def deleteedge(g, f, t):
	# g <- graph in which we will make an edge
	# f <- starting node (from)
	# t <- ending node (to)
	graph[f].remove(t) if t in graph[f] else None

def deleteedgeundirected(g, f, t):
	# g <- graph in which we will make an edge
	# f <- starting node (from)
	# t <- ending node (to)
	graph[f].remove(t) if t in graph[f] else None
	graph[t].remove(f) if f in graph[t] else None

def displaygraph(g):
	for z in range(len(g)):
		print(str(z) + " ", end='')
		print(graph[z])

# BFS algorithm
# create a queue
# add start node to queue
# while queue is not empty,
# pop the head of the queue, mark it as seen
# add its unseen neighbors to the queue

def bfs(g, start):
	# pop() and append() let us interface with the generic list as a queue
	queue = [] # used to store neighbors
	seen = [] # used to store seen nodes
	queue.append(start)
	while len(queue) > 0:
		print(queue)
		curr = queue.pop(0)
		seen.append(curr)
		for v in graph[curr]:
			if v not in seen:
				queue.append(v)
				seen.append(v)

def dfs(g, start, seen=[]):
	print("commencing DFS on {}".format(start))
	if len(seen) == 0:
		seen.append(start)
	visited = seen
	for v in g[start]:
		if v not in visited:
			visited.append(v)
			dfs(g, v, visited)

def articulation_points(g):
	# articulation points are defined as vertices which, when removed would split the graph in two parts
	# a biconnected graph has no articulation points
	p = []

	# to solve this problem, we will first solve the problem of MST.
	# with a valid MST algorithm, we can modify it to elegantly find articulation points

	return p

# MST ALGORITHMS

# this code only works for non-weighted graphs, need to make a version where the edges have weights (objects)

def prims(g):
	# given a graph g, we want to return a list of edges for the MST
	# initialize list to contain starting vertex
	# while there exist vertices not in list
		# Find minimum weighted edge that connected a vertex in list to a vertex not in list
	return

def kruskals(g):
	# given a graph g, we want to return a list of edges for the MST
	return

makeedge(graph, 0, 2)
makeedge(graph, 0, 1)
makeedge(graph, 0, 5)
makeedge(graph, 1, 0)
makeedge(graph, 1, 2)
makeedge(graph, 2, 0)
makeedge(graph, 2, 1)
makeedge(graph, 2, 3)
makeedge(graph, 2, 4)
makeedge(graph, 3, 5)
makeedge(graph, 3, 4)
makeedge(graph, 3, 2)
makeedge(graph, 4, 3)
makeedge(graph, 4, 2)
makeedge(graph, 5, 3)
makeedge(graph, 5, 0)

print("Graph:")
displaygraph(graph)

print("BFS results:")
bfs(graph, 0)

print("DFS results:")
dfs(graph, 0)