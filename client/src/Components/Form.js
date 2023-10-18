import { useState } from "react"

function Form() {

  const [name, setName] = useState('')
  const [realm, setRealm] = useState('')

  const handleSubmit = (Event) => {
    Event.preventDefault()
    fetch("/api", {
      method: "POST",
      body: JSON.stringify({
        content: {
          "name": name,
          "realm": realm
        }
      }),
      headers: {
        "Content-type": "application/json; charset=UTF-8"
      }
    }).then(response => response.json())
      .then(message => {
        console.log(message)
        setName('')
        setRealm('')
      })
  }

  return (
    <form onSubmit={handleSubmit}>
      <input
        type="text"
        required
        value={name}
        onChange={(e) => setName(e.target.value)}
      ></input>
      <input
        type="text"
        required
        value={realm}
        onChange={(e) => setRealm(e.target.value)}
      ></input>
      <input type="submit"></input>
    </form>
  );
}

export { Form };