package Clases.PDF;

public class PdfVO {

    /*Todo los atributos*/
    int id;
    String titulo;
    String tipo;
    //int expediente;
    //int estudiante;
    byte[] archivopdf;

    public PdfVO() {
    }

    /*Todo los codigos get*/
    public String getTitulopdf() {
        return titulo;
    }

    public String getTipopdf() {
        return tipo;
    }

    public byte[] getArchivopdf() {
        return archivopdf;
    }


    /*Todo los codigos set*/
    public void setTipopdf(String tipo) {
        this.tipo = tipo;
    }

    public void setTitulopdf(String titulo) {
        this.titulo = titulo;
    }

    public void setArchivopdf(byte[] archivopdf) {
        this.archivopdf = archivopdf;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    /*
    public int getExpediente() {
        return expediente;
    }

    public void setExpediente(int expediente) {
        this.expediente = expediente;
    }

    public int getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(int estudiante) {
        this.estudiante = estudiante;
    }
    */
}
