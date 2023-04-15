package main.Entities.AnimateEntities.DynamicEntities.Enemies.AI;

import java.util.*;
public class AStar {
    private Node[][] _searchArea;
    private PriorityQueue<Node> _openList;
    private Set<Node> _closedSet;
    private Node _initialNode;
    private Node _finalNode;

    private boolean is_finalNode(Node current_Node) {
        return current_Node.equals(_finalNode);
    }
    private boolean is_Empty(PriorityQueue<Node> _openList) {
        return _openList.size() == 0;
    }
    private void set_Block(int _row, int _col) {
        this._searchArea[_row][_col].setIs_Block(true);
    }
    public Node get_initialNode() {
        return _initialNode;
    }

    public void set_initialNode(Node _initialNode) {
        this._initialNode = _initialNode;
    }

    public Node get_finalNode() {
        return _finalNode;
    }

    public void set_finalNode(Node _finalNode) {
        this._finalNode = _finalNode;
    }

    public Node[][] get_searchArea() {
        return _searchArea;
    }

    public void set_searchArea(Node[][] _searchArea) {
        this._searchArea = _searchArea;
    }

    public PriorityQueue<Node> get_openList() {
        return _openList;
    }

    public void set_openList(PriorityQueue<Node> _openList) {
        this._openList = _openList;
    }

    public Set<Node> get_closedSet() {
        return _closedSet;
    }

    public void set_closedSet(Set<Node> _closedSet) {
        this._closedSet = _closedSet;
    }

    public AStar(int _rows, int _cols, Node _initialNode, Node _finalNode) {
        set_initialNode(_initialNode);
        set_finalNode(_finalNode);
        this._searchArea = new Node[_rows][_cols];
        this._openList = new PriorityQueue<>(Comparator.comparingInt(Node::getfF));
        set_Node();
        this._closedSet = new HashSet<>();
    }
     private void set_Node() {
        for(int i = 0; i < _searchArea.length; i++) {
            for (int j = 0; j < _searchArea[0].length; j++) {
                Node _node = new Node(i, j);
                _node.calculateHeuristic(get_finalNode());
                this._searchArea[i][j] = _node;
            }
        }
     }
     public  void set_Block(int[][] blocks_Arr, int _count) {
        for(int i = 0; i < _count; i++) {
            int _row = blocks_Arr[i][0];
            int _col = blocks_Arr[i][1];
            set_Block(_row, _col);
        }
     }

     public List<Node> get_Path(Node current_Node) {
        List<Node> _path = new ArrayList<Node>();
        _path.add(current_Node);
        Node _parent;
        while ((_parent = current_Node.getParent()) != null) {
            _path.add(0, _parent);
            current_Node = _parent;
        }
        return _path;
    }
    private void add_AdjacnetNodes(Node current_node) {
        add_AdjacnetUpperRow(current_node);
        add_AdjacnetMiddleRow(current_node);
        add_AdjacnetLowerRow(current_node);
    }

    private void add_AdjacnetLowerRow(Node current_Node) {
        int _row = current_Node.get_row();
        int _col = current_Node.get_col();
        int lower_Row = _row + 1;
        if(lower_Row < get_searchArea().length) {
            if(_col - 1 <= 0) {
                check_Node(current_Node, _col - 1, lower_Row);
            }
            if(_col + 1 < get_searchArea()[0].length) {
                check_Node(current_Node, _col + 1, lower_Row);
            }
            check_Node(current_Node, _col, lower_Row);
        }
    }

    private void add_AdjacnetMiddleRow(Node current_Node) {
        int _row = current_Node.get_row();
        int _col = current_Node.get_col();
        if(_col - 1 >= 0) {
            check_Node(current_Node, _col - 1, _row);
        }
        if(_col + 1 < get_searchArea()[0].length) {
            check_Node(current_Node, _col + 1, _row);
        }
    }
    private void add_AdjacnetUpperRow(Node current_Node) {
        int _row = current_Node.get_row();
        int _col = current_Node.get_col();
        int upper_Row = _row - 1;
        if(upper_Row >= 0) {
            if(_col - 1 >= 0) {
                check_Node(current_Node, _col - 1, upper_Row);
            }

            if(_col + 1 < get_searchArea()[0].length) {
                check_Node(current_Node, _col + 1, upper_Row);
            }
            check_Node(current_Node, _col, upper_Row);
        }
    }

    private void check_Node(Node current_Node, int _col, int _row) {
        Node adjacent_Node = get_searchArea()[_row][_col];
        if(!adjacent_Node.isIs_Block() && !get_closedSet().contains(adjacent_Node)) {
            if(!get_openList().contains(adjacent_Node)) {
                adjacent_Node.set_NodeData(current_Node);
                get_openList().add(adjacent_Node);
            } else {
                boolean changed = adjacent_Node.check_BetterPath(current_Node);
                if(changed) {
                    get_openList().remove(adjacent_Node);
                    get_openList().add(adjacent_Node);
                }
            }
        }
    }
}
