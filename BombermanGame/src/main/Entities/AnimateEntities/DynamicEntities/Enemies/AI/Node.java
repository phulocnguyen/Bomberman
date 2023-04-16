package main.Entities.AnimateEntities.DynamicEntities.Enemies.AI;

public class Node {
    private int gG;
    private int fF;
    private int hH;
    private int _row;
    private int _col;
    private boolean is_Block;
    private Node parent;

    public Node(int _row, int _col) {
        super();
        this._col = _col;
        this._row = _row;
    }

    public int gethH() {
        return hH;
    }

    public void sethH(int hH) {
        this.hH = hH;
    }

    public int getgG() {
        return gG;
    }

    public void setgG(int gG) {
        this.gG = gG;
    }

    public int getfF() {
        return fF;
    }

    public void setfF(int fF) {
        this.fF = fF;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public void setIs_Block(boolean is_Block) {
        this.is_Block = is_Block;
    }

    public boolean isIs_Block() {
        return is_Block;
    }

    public int get_col() {
        return _col;
    }

    public void set_col(int _col) {
        this._col = _col;
    }

    public int get_row() {
        return _row;
    }

    public void set_row(int _row) {
        this._row = _row;
    }

    public void calculateHeuristic(Node final_Node) {
        this.hH = Math.abs(final_Node.get_row() - get_row() + Math.abs(final_Node.get_col() - get_col()));
    }
    public void set_NodeData(Node current_Node) {
        int g_Cost = current_Node.getgG();
        setParent(current_Node);
        setgG(g_Cost);
        calculate_FinalCost();
    }
    private void calculate_FinalCost() {
        int final_Cost = getgG() + gethH();
        setfF(final_Cost);
    }
    public boolean check_BetterPath(Node current_Node) {
        int g_Cost = current_Node. getgG();
        if(g_Cost < getgG()) {
            set_NodeData(current_Node);
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        Node other = (Node) obj;
        return this.get_row() == other.get_row() && this.get_col() == other.get_col();
    }
    public String toString() {
        return "Node [row=" + _row + ", col=" + _col + "]";
    }
}