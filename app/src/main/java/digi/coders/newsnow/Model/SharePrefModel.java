package digi.coders.newsnow.Model;

public class SharePrefModel {


    public int ids;
    public String fullnames,email,password, phoneNo;
    public boolean isRadioButtonSelected;

    public SharePrefModel() {
    }

    public SharePrefModel(String fullnames, String email, String password, String phoneNo, boolean isRadioButtonSelected) {
        this.fullnames = fullnames;
        this.email = email;
        this.password = password;
        this.phoneNo = phoneNo;
        this.isRadioButtonSelected = isRadioButtonSelected;
    }

    public SharePrefModel(int ids, String fullnames, String email, String password, String phoneNo, boolean isRadioButtonSelected) {
        this.ids = ids;
        this.fullnames = fullnames;
        this.email = email;
        this.password = password;
        this.phoneNo = phoneNo;
        this.isRadioButtonSelected = isRadioButtonSelected;
    }

    public int getIds() {
        return ids;
    }

    public void setIds(int ids) {
        this.ids = ids;
    }

    public String getFullnames() {
        return fullnames;
    }

    public void setFullnames(String fullnames) {
        this.fullnames = fullnames;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public boolean isRadioButtonSelected() {
        return isRadioButtonSelected;
    }

    public void setRadioButtonSelected(boolean radioButtonSelected) {
        isRadioButtonSelected = radioButtonSelected;
    }
}
