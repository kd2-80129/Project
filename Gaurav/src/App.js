import { BrowserRouter, Route, Routes } from 'react-router-dom';
import './App.css';
import Layout from './Layout';
import SignUp from './component/SignUp';
import Login from './component/Login';
import Home from './component/Home';
import ContactUs from './component/ContactUs';

function App() {
  return (
    <BrowserRouter>
      <Layout >
        <Routes>
          <Route path='/signup' element={<SignUp />} />
          <Route path='/login' element={<Login />} />
          <Route path='/home' element={<Home />} />
          <Route path='/contactus' element={<ContactUs />} />
        </Routes>
      </Layout>
    </BrowserRouter >
  );
}

export default App;
