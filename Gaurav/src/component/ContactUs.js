import * as React from 'react';
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import CardMedia from '@mui/material/CardMedia';
import Typography from '@mui/material/Typography';
import { Button } from '@mui/material';

// const contactDetails = {
//   Name: 'Username',
//   'Mobile No': '+91 1111111111',
//   Email: 'useremail@gmial.com',
//   image: "https://plus.unsplash.com/premium_photo-1675745329378-5573c360f69f?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MjF8fGhvdGVsfGVufDB8MHwwfHx8MA%3D%3D",
//   alt: "User Logo"
// }

// const contactDetail = localStorage.getItem('userDetails')

export default function ContactUs() {

  const [contactDetails, setContactDetail] = React.useState({});
  const handleResetPass = () => {
    // Integrate your api for reseting password
    console.log(contactDetails, " this is for reset pass");
  }
  const handleEditInfo = (e) => {
    e.preventDefault();
    // Integrate your api for editing user info
    console.log(contactDetails, " this is data of user need to edit");
  }
  React.useEffect(() => {
    const userData = sessionStorage.getItem('userDetails')
    const jsonObject = JSON.parse(userData);
    setContactDetail(jsonObject)
  }, [])

  return (
    <Card >
      <div style={{ display: "flex", padding: "20px 40px", justifyContent: "space-evenly" }}>
        <CardMedia
          component="img"
          height="300"
          sx={{ width: 300, borderRadius: 10 }}
          image='https://plus.unsplash.com/premium_photo-1675745329378-5573c360f69f?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MjF8fGhvdGVsfGVufDB8MHwwfHx8MA%3D%3D'
          alt='alt'
        />
        <CardContent>
          <Typography sx={{ margin: '30px 5px' }} gutterBottom variant="h5" component="div">
            Name : {contactDetails['firstName']}
          </Typography>
          <Typography sx={{ margin: '30px 5px' }} gutterBottom variant="h5" component="div">
            Mobile No : {contactDetails['mobileNo']}
          </Typography>
          <Typography sx={{ margin: '30px 5px' }} gutterBottom variant="h5" component="div">
            Email : {contactDetails['email']}
          </Typography>
        </CardContent>
      </div>
      <CardContent sx={{ width: "1000px", display: "flex", justifyContent: "end" }}>

        {/* <Button onClick={() => handleEditInfo()} sx={{ margin: "10px 20px" }} variant="contained">Edit Your Information</Button>
        <Button onClick={() => handleResetPass()} sx={{ margin: "10px 20px" }} variant="contained">Reset Password</Button>
         */}
      </CardContent>
    </Card>
  );
}