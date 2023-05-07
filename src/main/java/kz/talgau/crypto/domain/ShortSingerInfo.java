package kz.talgau.crypto.domain;

import java.util.Date;

public class ShortSingerInfo {
    private SubjectDN subjectDN;
    private Date startTime;
    private Date endTime;

    public SubjectDN getSubjectDN() {
        return subjectDN;
    }

    public void setSubjectDN(SubjectDN subjectDN) {
        this.subjectDN = subjectDN;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}