package Models;

import java.time.LocalDateTime;

public class Report {

    private int reportId;
    private int userId;
    private int projectId;
    private LocalDateTime date;
    private String description;

    public Report(){

    }
    public Report(int ReportId, int UserId, int ProjectId, LocalDateTime Date, String Description){
        this.reportId = ReportId;
        this.userId = UserId;
        this.projectId = ProjectId;
        this.date = Date;
        this.description = Description;
    }
    public void setReportId(int reportId) {
        this.reportId = reportId;
    }
    public int getReportId() {
        return reportId;
    }
    public void setUserId(int userId) {this.userId = userId;}
    public int getUserId() {return userId;}
    public void setProjectId(int projectId) {this.projectId = projectId;}
    public int getProjectId() {return projectId;}
    public void setDate(LocalDateTime date) {this.date = date;}
    public LocalDateTime getDate() {return date;}
    public void setDescription(String description) {this.description = description;}
    public String getDescription() {return description;}
}
