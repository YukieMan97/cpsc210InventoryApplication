package model.items;

interface GeneralInformation {
    int getQuantity();

    double getPriceTag();

    double setPriceTag(double newPriceTag);

    String getInformation();

    boolean containsNameOrTitle(String givenNameOrTitle);

}