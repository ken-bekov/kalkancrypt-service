package kz.talgau.crypto.domain;

public class SubjectDN {
    private String cn;
    private String serialNumber;
    private String g;
    private String o;
    private String e;
    private String surname;
    private String ou;

    public static SubjectDN parse(String subjectDnStr) {
        SubjectDN subject = new SubjectDN();
        String[] parts = subjectDnStr.split(",");
        for (String part : parts) {
            String[] nameValue = part.split("=");
            String name = nameValue.length > 0 ? nameValue[0] : "";
            String value = nameValue.length > 1 ? nameValue[1] : "";
            switch (name) {
                case "SERIALNUMBER":
                    subject.setSerialNumber(value);
                    break;
                case "CN":
                    subject.setCn(value);
                    break;
                case "G":
                    subject.setG(value);
                    break;
                case "O":
                    subject.setO(value);
                    break;
                case "E":
                    subject.setE(value);
                    break;
                case "SURNAME":
                    subject.setSurname(value);
                    break;
                case "OU":
                    subject.setOu(value);
                    break;
            }
        }
        return subject;
    }

    public String getCn() {
        return cn;
    }

    private void setCn(String cn) {
        this.cn = cn;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    private void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getG() {
        return g;
    }

    private void setG(String g) {
        this.g = g;
    }

    public String getO() {
        return o;
    }

    private void setO(String o) {
        this.o = o;
    }

    public String getE() {
        return e;
    }

    public void setE(String e) {
        this.e = e;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getOu() {
        return ou;
    }

    public void setOu(String ou) {
        this.ou = ou;
    }
}
