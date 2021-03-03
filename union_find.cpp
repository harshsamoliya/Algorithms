vector<int> parent, ranke;

void make_set(int v) {
	parent[v] = v;
	ranke[v] = 0;
}
int find_set(int v) {
	if (parent[v] == v) {
		return v;
	}
	return parent[v] = find_set(parent[v]);
}

void union_sets(int a, int b) {
	a = find_set(a);
	b = find_set(b);
	if (a != b) {
		if (ranke[a] < ranke[b]) {

			swap(a, b);
		}
		parent[b] = a;
		// small parent will become child of bigger parent
		if (ranke[a] == ranke[b]) {
			ranke[a]++;
		}
		// ranke will increase by 1
	}
}


struct Edge {
	int u, v, weight;
	bool operator<(Edge const& other) {
		return weight < other.weight;
	}
};

vector<Edge> edges;
void krushkal(int n) {
	int Mincost = 0;
	ranke.resize(n);
	parent.resize(n);
	for (int i = 0 ; i < n; i++) {
		make_set(i);
	}
	sort(all(edges));
	for (Edge e : edges) {
		if (find_set(e.u) != find_set(e.v)) {
			Mincost += e.weight;
			union_sets(e.u, e.v);
		}
	}
	cout << Mincost << endl;
}
void solve() {
	edges.push_back({1, 2, 1});
	edges.push_back({2, 3, 5});
	edges.push_back({ 3, 17, 7});
	edges.push_back({17, 18, 8});
	edges.push_back({18, 1, 9});
	krushkal(5);

}
