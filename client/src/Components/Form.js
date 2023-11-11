const Form = ({ formData, setFormData, handleFormSubmit }) => {
  const handleChange = (e) => {
    const value = e.target.value;
    setFormData({ ...formData, [e.target.name]: value });
  }
  const handleKeyPress = (e) => {
    if (e.key === "Enter") {
      handleFormSubmit();
    }
  }
  return (
    <>
      <div className="container-fluid">
        <div className="row justify-content-center">
          <div className="col-md-4">
            <div className="card">
              <div className="card-body">
                <div className="mb-3">
                  <label className="form-label">
                    Name
                  </label>
                  <input
                    className="form-control"
                    type="text"
                    required
                    name="name"
                    value={formData.name}
                    onChange={handleChange}
                    onKeyDown={handleKeyPress}
                  ></input>
                </div>
                <div className="mb-3">
                  <label className="form-label">
                    Realm
                  </label>
                  <input
                    className="form-control"
                    type="text"
                    required
                    name="realm"
                    value={formData.realm}
                    onChange={handleChange}
                    onKeyDown={handleKeyPress}
                  ></input>
                </div>
                  <button className="btn btn-primary float-end" onClick={handleFormSubmit} type="submit">Submit</button>
              </div>
            </div>
          </div>
        </div>
      </div>
    </>
  );
}
export { Form };