package Homework.hw3;

public enum Benefits {
    PRACTISE("To include good practices\n" +
            "and ideas from successful\n" +
            "EPAM project"),
    CUSTOM("To be flexible and\n" +
            "customizable"),
    MULTI("To be multiplatform"),
    BASE("Already have good base\n" +
            "(about 20 internal and\n" +
            "some external projects),\n" +
            "wish to get more…");

    String benefitText;

    Benefits(String benefitText) {
        this.benefitText = benefitText;
    }

    @Override
    public String toString(){
        return benefitText;
    }
}
