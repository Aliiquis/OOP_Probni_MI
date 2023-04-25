package hr.fer.oop.mtexam.task2;

class MultiAgentSystem {
    private static int generatedId = 0;
    private Agent[] agents;

    public MultiAgentSystem(int numberOfAgents) {
        this.agents = (numberOfAgents < 0 ? new Agent[1] : new Agent[numberOfAgents]);
    }

    public int getNumberOfAgents() {
        return agents.length;
    }

    public Agent[] getAgents() {
        return agents;
    }

    public void addAgent(Agent agent) {
        if (generatedId - 1 < agents.length) {
            agents[generatedId - 1] = agent;
        }
    }

    public void systemInfo() {
        for (Agent a : agents) {
            if (a != null) {
                System.out.print(String.format("%s %s\n", a.getAgentType(), a));
            }
        }
    }

    public static int generateId() {
        return generatedId++;
    }
}
