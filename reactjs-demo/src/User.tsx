import React from 'react';
import './App.css';

type UserProps = {
  name: string,
  email: string
}

/**
 *
 * @param props
 * @returns
 */
const User = ({name, email}: UserProps) => {
  return (
    <div>
      <h1>User</h1>
        <p>This is the user page.</p>
        <p>{name}</p>
        <p>{email}</p>
    </div>
  );
}

export default User;