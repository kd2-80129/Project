import { BrowserRouter, Route, Routes } from 'react-router-dom';
import './App.css';
import Layout from './Layout';
import SignUp from './component/SignUp';
import Login from './component/Login';
import Home from './component/Home';
import ContactUs from './component/ContactUs';
import RestorentList from './component/RestorentList';
import TabledDetails from './component/TabledDetails';

function App() {
  return (
    <BrowserRouter>
      <Layout >
        <Routes>
          <Route path='/' element={<Home />} />
          <Route path='/signup' element={<SignUp />} />
          <Route path='/login' element={<Login />} />
          <Route path='/home' element={<Home />} />
          <Route path='/tableDetails' element={<TabledDetails />} />
          <Route path='/contactus' element={<ContactUs />} />
          <Route path='/restorantList' element={<RestorentList />} />
        </Routes>
      </Layout>
    </BrowserRouter >
  );
}

export default App;
