package model.items;

interface GeneralInformation {
    int getQuantity();

    double getPriceTag();

    String getInformation();

    boolean containsNameOrTitle(String givenNameOrTitle);

}