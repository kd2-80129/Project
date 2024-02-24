import * as React from 'react';
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import CardMedia from '@mui/material/CardMedia';
import Typography from '@mui/material/Typography';
import { Button, FormControlLabel, Switch } from '@mui/material';
import { useNavigate } from 'react-router-dom';
import { useLocation } from 'react-router-dom';


export default function OwnerDetail() {
    const location = useLocation();
    const { state } = location;
    const [contactDetails, setContactDetail] = React.useState({});
    const navigate = useNavigate();
    const handleAddRestaurant = (e) => {        
        e.preventDefault();
        navigate('/addRestaurant', {state : state})
    }
    React.useEffect(() => {
        const userData = sessionStorage.getItem('userDetails')
        const jsonObject = JSON.parse(userData);
        setContactDetail(jsonObject)
    }, [])

    return (
        <Card sx={{ width: '90%' }} >
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
                        Owner Name : {contactDetails['firstName']}
                    </Typography>
                    <Typography sx={{ margin: '30px 5px' }} gutterBottom variant="h6" component="div">
                        Lorem ipsum dolor, sit amet consectetur adipisicing elit. Molestias, sunt! Odit saepe, totam necessitatibus laborum commodi enim blanditiis quae aperiam natus corrupti esse amet officiis perferendis at recusandae. Dignissimos distinctio labore nemo recusandae quas culpa!
                    </Typography>
                    <Typography sx={{ margin: '30px 5px' }} gutterBottom variant="h5" component="div">
                        Restaurant Name
                    </Typography>
                    <Typography sx={{ margin: '30px 5px' }} gutterBottom variant="h6" component="div">
                        Lorem ipsum dolor, sit amet consectetur adipisicing elit. Molestias, sunt! Odit saepe, totam necessitatibus laborum commodi enim blanditiis quae aperiam natus corrupti esse amet officiis perferendis at recusandae. Dignissimos distinctio labore nemo recusandae quas culpa!
                    </Typography>
                </CardContent>
                <CardContent>
                    <FormControlLabel required control={<Switch />} label="Available" />
                    <Button onClick={handleAddRestaurant} sx={{ margin: "10px 20px" }} variant="contained">Add Restaurant</Button>
                </CardContent>
            </div>
        </Card>
    );
}