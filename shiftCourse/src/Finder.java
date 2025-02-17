public class Finder {
    public void findWorkers(DataContainers containers, String dep, int i) {
        if (containers.getManagers().get(i).getDepartment().equals(dep)) {
            containers.addTemp(containers.getManagers().get(i));
            for(int j=0; j<containers.getEmployees().size(); j++) {
                if (containers.getEmployees().get(j).getManagerId() ==
                        containers.getManagers().get(i).getId()) {
                    containers.addTemp(containers.getEmployees().get(j));
                }
            }
        }
    }
}
