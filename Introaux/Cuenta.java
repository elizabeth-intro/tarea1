
public class Cuenta {

    private String nombre;
    private String numeroCuenta;
    private double saldo;
    public Cuenta() {
    }
    public Cuenta(String nombre, String numeroCuenta, double saldo){                         
        this.nombre = nombre;
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
    }
    public Cuenta(final Cuenta c) {
        nombre = c.nombre;
        numeroCuenta = c.numeroCuenta;
        saldo = c.saldo;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    public String getNombre() {
        return nombre;
    }
    public String getNumeroCuenta() {
        return numeroCuenta;
    }
    public double getSaldo() {
        return saldo;
    }
    public boolean ingreso(double n) {
        boolean ingresoCorrecto = true;
        if (n < 0) {
            ingresoCorrecto = false;
        } else {
            saldo = saldo + n;
        }
        return ingresoCorrecto;
    }
    public boolean reintegro(double n) {
        boolean reintegroCorrecto = true;                                                                         
        if (n < 0) {
            reintegroCorrecto = false;
        } else if (saldo >= n) {
            saldo -= n;
        } else {
            reintegroCorrecto = false;
        }
        return reintegroCorrecto;
    }
    public boolean transferencia(Cuenta cuenta, double n) {
        boolean correcto = true;
        if (n < 0) {
            correcto = false;
        } else if (saldo >= n) {
            reintegro(n);
            cuenta.ingreso(n);
        } else {
            correcto = false;
        }
        return correcto;
    }
    
}