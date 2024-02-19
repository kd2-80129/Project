import { useState } from 'react'
import { toast } from 'react-toastify'
import { signin } from '../services/user'

export function Login() {
  const [email, setEmail] = useState('')
  const [password, setPassword] = useState('')
  const [result, setResult] = useState('')

  const onLogin = async () => {
    if (email.length == 0) {
      toast.warn('enter email')
    } else if (password.length == 0) {
      toast.warn('enter password')
    } else {
      const response = await signin(email, password)
      if (response['status'] == 'success') {
        setResult('success')
        toast.success('successfully logged in')
      } else {
        setResult('error')
        toast.error(response['error'])
      }
    }
  }

  return (
    <div>
      <h1 className='m-3' style={{ textAlign: 'center' }}>
        Login
      </h1>

      <div className='row'>
        <div className='col'></div>
        <div className='col'>
          <div className='mb-3'>
            <label htmlFor=''>Email</label>
            <input
              onChange={(e) => setEmail(e.target.value)}
              type='email'
              className='form-control'
              id='email'
              placeholder='email here'
            />
          </div>
          <div className='mb-3'>
            <label htmlFor=''>Password</label>
            <input
              onChange={(e) => setPassword(e.target.value)}
              type='password'
              className='form-control'
              id='password'
              placeholder='password here'
            />
          </div>
          <div className='mb-3' id='result'>
            {result}
          </div>
          <div className='mb-3'>
            <button onClick={onLogin} className='btn btn-success'>
              Login
            </button>
          </div>
        </div>
        <div className='col'></div>
      </div>
    </div>
  )
}

export default Login
