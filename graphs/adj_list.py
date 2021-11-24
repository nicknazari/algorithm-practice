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

def bfs(g, start):
	# pop() and append() let us interface with the generic list as a queue
	queue = [] # used to store neighbors
	seen = [] # used to store seen nodes
	queue.append(start)
	while len(queue) > 0:
		print(queue)
		curr = queue.pop(0)
		for v in graph[curr]:
			if v not in seen:
				queue.append(v)
				seen.append(v)
		seen.append(curr)

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

displaygraph(graph)

bfs(graph, 0)