graph = []
vertices = 5
for x in range(vertices):
	graph.append([])

def makeedge(g, f, t):
	# g <- graph in which we will make an edge
	# f <- starting node (from)
	# t <- ending node (to)
	graph[f].append(t) if f < len(graph) and t < len(graph) else None

def deleteedge(g, f, t):
	# g <- graph in which we will make an edge
	# f <- starting node (from)
	# t <- ending node (to)
	graph[f].remove(t) if t in graph[f] else None

def displaygraph(g):
	for z in range(len(g)):
		print(str(z) + " ", end='')
		print(graph[z])

print("empty")
displaygraph(graph)

print("making some edges")
makeedge(graph, 0, 2)
makeedge(graph, 0, 3)
makeedge(graph, 0, 5) # invalid edge, should not appear
makeedge(graph, 2, 4)
makeedge(graph, 3, 1)
makeedge(graph, 1, 4)
makeedge(graph, 4, 0)
displaygraph(graph)

print("delete an edge")
deleteedge(graph, 0,2)
displaygraph(graph)
