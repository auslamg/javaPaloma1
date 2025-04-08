package apuntesclase.ficheros.ddd_example;

public final class DNI {

    int numbers;
    char letter;

    public DNI(int numbers, char letter) throws IllegalArgumentException {
        if ((String.valueOf(numbers) + String.valueOf(letter)).length() != 9) {
            throw new IllegalArgumentException("Wrong amount of digits while instancing DNI");
        }
        this.numbers = numbers;
        this.letter = letter;
    }

    public DNI(int numbers, String letter) throws IllegalArgumentException {
        if ((String.valueOf(numbers) + letter).length() != 9 ||
                (letter.length() != 1)) {
            throw new IllegalArgumentException("Wrong amount of digits while instancing DNI");
        }
        this.numbers = numbers;
        this.letter = letter.charAt(0);
    }

    public DNI(String fullDNI) {
        try {
            if ((fullDNI.length() != 9)) {
                throw new IllegalArgumentException();
            }

            numbers = Integer.parseInt(fullDNI.substring(0, fullDNI.length() - 1));
            letter = fullDNI.charAt(8);

        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Wrong amount of digits while instancing DNI");
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid format for DNI: " + fullDNI);
        }
    }

    @Override
    public String toString() {
        return "" + numbers + letter;
    }
}
