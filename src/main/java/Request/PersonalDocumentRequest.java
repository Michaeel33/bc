package Request;

import lombok.Data;

public class PersonalDocumentRequest {

        private Long perId;
        private String customerId;
        private int country;
        private boolean isVerified;

        public Long getPerId() {
                return perId;
        }

        public void setPerId(Long perId) {
                this.perId = perId;
        }

        public String getCustomerId() {
                return customerId;
        }

        public void setCustomerId(String customerId) {
                this.customerId = customerId;
        }

        public int getCountry() {
                return country;
        }

        public void setCountry(int country) {
                this.country = country;
        }



        public boolean getIsVerified() {
                return isVerified;
        }
        public void setVerified(boolean verified) {
                isVerified = verified;
        }
}
