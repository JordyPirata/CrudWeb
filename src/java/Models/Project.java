package Models;

public class Project {
    private int projectId;
    private String projectDescription;
    private String responsibleName;
    public Project(){

    }
    public Project (int ProjectId,String ProjectDescription, String ResponsibleName){
        this.projectId = ProjectId;
        this.projectDescription = ProjectDescription;
        this.responsibleName = ResponsibleName;
    }
    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }
    public int getProjectId() {
        return projectId;
    }
    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }
    public String getProjectDescription() {
        return projectDescription;
    }
    public void setResponsibleName(String responsibleName) {
        this.responsibleName = responsibleName;
    }
    public String getResponsibleName() {
        return responsibleName;
    }
}
