

protected org.apache.struts.upload.FormFile image;

/**
 * Retrieve a representation of the file the user has uploaded
 *
 * @return FormFile the uploaded file
 */
public org.apache.struts.upload.FormFile getImage() {
    return image;
}

/**
 * Set a representation of the file the user has uploaded
 *
 * @param file the file to upload
 */
public void setImage(org.apache.struts.upload.FormFile image) {
    this.image = image;
}

