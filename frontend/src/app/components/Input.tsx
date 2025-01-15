import React from 'react'

const Input = ({ nombre, error, onChange, value }:{nombre:string, error:string, onChange:Function, value:string}) => {
  return (
      <div>
          <label htmlFor="email">{nombre}</label>
         <input type="email" id='email' name='user_email' />
          
    </div>
  )
}

export default Input
