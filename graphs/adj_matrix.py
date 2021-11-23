graph = []
vertices = 5
for i in range(vertices):
	graph.append([])
	for j in range(vertices):
		graph[i].append(0)

def makeedge(g, f, t):
	g[f][t] = 1

def deleteedge(g, f, t):
	g[f][t] = 0
	
def displaygraph(g):
	# display the matrix
	for i in range(vertices):
		print(graph[i])

print("empty")
displaygraph(graph)

print("add some edges")
makeedge(graph, 0, 2)
makeedge(graph, 2, 3)
makeedge(graph, 2, 4)
makeedge(graph, 3, 0)
makeedge(graph, 3, 1)
makeedge(graph, 4, 0)
makeedge(graph, 4, 3)
displaygraph(graph)

print("delete some edges")
deleteedge(graph, 0, 2)
deleteedge(graph, 3, 0)
deleteedge(graph, 4, 0)
displaygraph(graph)
