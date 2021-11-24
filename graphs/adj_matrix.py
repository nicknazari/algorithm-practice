graph = []
vertices = 6
for i in range(vertices):
	graph.append([])
	for j in range(vertices):
		graph[i].append(0)

def makeedge(g, f, t):
	g[f][t] = 1

def makeedgeundirected(g, f, t):
	g[f][t] = 1
	g[t][f] = 1

def deleteedge(g, f, t):
	g[f][t] = 0

def deleteedgeundirected(g, f, t):
	g[f][t] = 0
	g[t][f] = 1
	
# helper method to get neighbors of a vertice
def neighbors(g, v):
	n = []
	# add to n the index of all elements which are 1
	for i, j in enumerate(g[v]):
		n.append(i) if j == 1 else None 
	return n

	# almost works, but list contains None values. try again
	return [i if j == 1 else None for i,j in enumerate(g[v])]

def bfs(g, start):
	queue = []
	seen = []
	queue.append(start)
	while len(queue) > 0:
		print(queue)
		curr = queue.pop(0)
		seen.append(curr)
		# for each unseen neighbor of curr, append it to queue and mark it as seen
		# neighbors of curr are the indices of graph[curr] that are equal to 1
		n = neighbors(g, curr)
		for v in n:
			if v not in seen:
				queue.append(v)
				seen.append(v)

def displaygraph(g):
	# display the matrix
	for i in range(len(g)):
		print(g[i])

def dfs(g, start, seen=[]):
	print("commencing DFS on {}".format(start))
	if len(seen) == 0:
		seen.append(start)
	visited = seen
	for v in neighbors(g, start):
		if v not in visited:
			visited.append(v)
			dfs(g, v, visited)

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