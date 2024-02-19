import { ToastContainer } from 'react-toastify'
import 'react-toastify/dist/ReactToastify.css'
import './App.css'
import Login from './pages/Signin'

function App() {
  return (
    <div className='container'>
      <Login />

      <ToastContainer />
    </div>
  )
}

export default App
