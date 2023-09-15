package entidades;

public class Articulos {

    private int id;
    private int categoriaId;
    private String categoriaNombre;
    private String nombre;
    private String codigo;
    private double precioVenta;
    private Integer stock;
    private String descripcion;
    private String imagen;
    private boolean activo;


    public Articulos() {
        }  
        
    public Articulos(int id, int categoriaId, String categoriaNombre, String codigo, String nombre,  double precioVenta, int stock, String descripcion, String imagen, boolean activo) {
        this.id = id;
        this.categoriaId = categoriaId;
        this.categoriaNombre = categoriaNombre;       
        this.codigo = codigo;        
         this.nombre = nombre;
        this.precioVenta = precioVenta;
        this.stock = stock;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.activo = activo;
    }

    public Articulos(int id, String codigo, String nombre, double precioVenta, int stock) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.precioVenta = precioVenta;
        this.stock = stock;

    }


    public int getId() {
        return id;
    }

  
    public void setId(int id) {
        this.id = id;
    }

 
    public int getCategoriaId() {
        return categoriaId;
    }

  
    public void setCategoriaId(int categoriaId) {
        this.categoriaId = categoriaId;
    }

  
    public String getCategoriaNombre() {
        return categoriaNombre;
    }

    
    public void setCategoriaNombre(String categoriaNombre) {
        this.categoriaNombre = categoriaNombre;
    }

 
    public String getNombre() {
        return nombre;
    }

  
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

 
    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

   
    public int getStock() {
        return stock;
    }

  
    public void setStock(int stock) {
        this.stock = stock;
    }

   
    public String getDescripcion() {
        return descripcion;
    }

   
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

 
    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

  
    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {

        return "Articulos{" + "id=" + id + ", categoriaId=" + categoriaId + ", categoriaNombre=" + categoriaNombre + ", nombre=" + nombre + ", codigo=" + codigo + ", precioVenta=" + precioVenta + ", stock=" + stock + ", descripcion=" + descripcion + ", imagen=" + imagen + ", activo=" + activo + '}';

         
    }

}

