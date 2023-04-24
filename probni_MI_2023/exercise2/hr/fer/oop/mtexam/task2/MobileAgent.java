package hr.fer.oop.mtexam.task2;

class MobileAgent extends Agent implements Movable {
    private int taskId;

    public MobileAgent(String name, int ID) {
        super(name, ID);
        doRemoteTask();
    }

    public int getTaskId() {
        return taskId;
    }

    @Override
    public void doRemoteTask() {
        this.taskId = (int) (Math.random() * 9) + 1;
    }

    @Override
    public String getAgentType() {
        return "mobile agent";
    }
}
