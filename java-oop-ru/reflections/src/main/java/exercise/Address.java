package exercise;

public class Address {

    @NotNull
    @MinLength
    private String country;

    @NotNull
    private String city;

    @NotNull
    private String street;

    @NotNull
    private String houseNumber;
    private String flatNumber;

    public Address(@NotNull String country, @NotNull String city, @NotNull String street,
                   @NotNull String houseNumber, String flatNumber) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
        this.flatNumber = flatNumber;
    }

    @NotNull
    public String getCountry() {
        return country;
    }

    public void setCountry(@NotNull String country) {
        this.country = country;
    }

    @NotNull
    public String getCity() {
        return city;
    }

    public void setCity(@NotNull String city) {
        this.city = city;
    }

    @NotNull
    public String getStreet() {
        return street;
    }

    public void setStreet(@NotNull String street) {
        this.street = street;
    }

    @NotNull
    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(@NotNull String houseNumber) {
        this.houseNumber = houseNumber;
    }
}

