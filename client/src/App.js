import { Form } from './Components/Form'
import { Character } from './Components/Character';
import './App.css';
import { useState } from 'react';


const App = () => {
  const [formData, setFormData] = useState({ name: '', realm: '' });
  const [response, setResponse] = useState('')

  const handleFormSubmit = async () => {
    const encodedName = encodeURIComponent(formData.name);
    const encodedRealm = encodeURIComponent(formData.realm);
    const response = await fetch(`/GetCharacterSummary?name=${encodedName}&realm=${encodedRealm}`, {
      method: "POST",
      headers: {
        "Content-type": "application/json; charset=UTF-8"
      },
      body: JSON.stringify({
        name: formData.name,
        realm: formData.realm  
      })
    }).then(response => response.json());
    setResponse(response);
  }

  return (
    <div className='container-fluid'>
      <div className='row'>
        <div className='col'>
          <h1 className='text-center'>
            WoW Profile
          </h1></div>
      </div>

      <Form
        formData={formData}
        setFormData={setFormData}
        handleFormSubmit={handleFormSubmit}
      />
      <Character response={response} />
    </div>
  );
}

export default App;
