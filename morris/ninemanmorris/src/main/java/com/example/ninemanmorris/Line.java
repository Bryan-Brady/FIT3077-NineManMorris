package com.example.ninemanmorris;

public class Line {
    private Node[] lineMember;
    private boolean isAMill;

    public Line(){
    }

    public Node[] getLineMember() {
        return lineMember;
    }

    public void setAllLineMemberMillStatus(boolean millStatus){
        for(Node node : this.lineMember){
            if(node.getChip() !=null)node.getChip().setPartOfAMill(millStatus);

        }
    }
    public void setLineMember(Node[] lineMember) {
        this.lineMember = lineMember;
    }

    public boolean isAMill() {
        return isAMill;
    }

    public void setAMill(boolean AMill) {
        isAMill = AMill;
    }
}
