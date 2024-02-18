import { Button, Card, CardActionArea, CardActions, CardContent, CardMedia, Chip, FormControl, InputLabel, MenuItem, Select, Stack, TextField, Typography } from '@mui/material'
import React, { useState } from 'react';
import { useLocation } from 'react-router-dom';

const TabledDetails = () => {

    const location = useLocation();
    const { state } = location;
    console.log("state from table details" + JSON.stringify(state))
    const [restaurantListDetail, setRestaurantListDetails] = React.useState({});
    const [selectedDate, setSelectedDate] = useState(null);
    const [selectedData, setSelectedData] = useState({
        "partySize": 0,
        "reservationDateTime": ""
    });
    const options = [
        { id: 1, time: '07:00PM' },
        { id: 2, time: '07:00PM' },
        { id: 3, time: '07:00PM' },
        { id: 4, time: '07:00PM' }
    ]

    const handleBookNow = async (e) => {
        // console.log("Integrate api for bill payment");
        setSelectedData({
            ...selectedData,
            ["reservationDateTime"]: new Date().toISOString()
            // here we are setting the date automatically
        })
        console.log(selectedData)

        try {

           const userDetailsData = sessionStorage.setItem('userDetails', JSON.stringify(responseData));

            const response = await fetch(`http://127.0.0.1:8080/${user}/${signin}`, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                    // Add any other headers if needed
                },
                body: JSON.stringify(signInData),
            });
            console.warn(response)
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            resetForm();
            const responseData = await response.json();

            sessionStorage.setItem('userDetails', JSON.stringify(responseData));

            navigate('/home')
            // Handle successful response here
            // const responseData = await response.json();
            // console.log(responseData);
        } catch (error) {
            console.error('Error:', error);
        }

    }

    const handleChange = (e) => {
        setSelectedData({
            ...selectedData,
            [e.target.name]: e.target.value
        })

    }
    React.useEffect(() => {
        setRestaurantListDetails(state[0])

    }, [])
    return (
        <div style={{ width: '100%', display: 'flex', justifyContent: 'center', padding: '20px' }}>
            <div style={{ width: '60%', border: '1px solid black', marginRight: '5px' }} >
                <Card>
                    <CardMedia
                        sx={{ height: 140 }}
                        image="https://images.unsplash.com/photo-1606787366850-de6330128bfc?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8M3x8Zm9vZHxlbnwwfDB8MHx8fDA%3D"
                        title="green iguana"
                    />
                    <CardContent>
                        <div style={{ width: '100%', display: 'flex', justifyContent: "space-between" }}>
                            <Typography gutterBottom variant="h5" component="div">
                                {restaurantListDetail.restaurantName}
                            </Typography>
                            <Typography gutterBottom variant="h6">
                                Rating 4.7/5.0
                            </Typography>
                        </div>
                        <Typography variant="body2" color="text.secondary">
                            Lizards are a widespread group of squamate reptiles, with over 6,000
                            species, ranging across all continents except Antarctica Lorem ipsum dolor sit amet consectetur adipisicing elit. Quibusdam eum id ratione magni, ab labore beatae reiciendis esse aliquid perferendis, impedit, dolore delectus velit tempora consequatur dolores. Fugiat, quis dolores?
                        </Typography>

                        <CardActions spacing={2}>
                            <Button variant="contained" marginRight='10px' size="small">Photos</Button>
                            <Button variant="contained" marginRight='10px' size="small">Review</Button>
                            <Button variant="contained" marginRight='10px' size="small">About</Button>
                        </CardActions>
                        <Typography gutterBottom variant="h5" component="div">
                            About
                        </Typography>
                        <Typography variant="body2" color="text.secondary">
                            Lizards are a widespread group of squamate reptiles, with over 6,000
                            species, ranging across all continents except Antarctica Lorem ipsum dolor sit amet consectetur adipisicing elit. Quibusdam eum id ratione magni, ab labore beatae reiciendis esse aliquid perferendis, impedit, dolore delectus velit tempora consequatur dolores. Fugiat, quis dolores?
                        </Typography>
                        <CardMedia
                            sx={{ height: 140, maxWidth: '70%' }}
                            image="https://images.unsplash.com/photo-1606787366850-de6330128bfc?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8M3x8Zm9vZHxlbnwwfDB8MHx8fDA%3D"
                            title="green iguana"
                        />

                        <Typography gutterBottom variant="h5" component="div">
                            Restaurant Features
                        </Typography>
                        <Typography variant="body2" color="text.secondary">
                            Lizards are a widespread group of squamate reptiles, with over 6,000
                            species, ranging across all continents except Antarctica Lorem ipsum dolor sit amet consectetur adipisicing elit. Quibusdam eum id ratione magni, ab labore beatae reiciendis esse aliquid perferendis, impedit, dolore delectus velit tempora consequatur dolores. Fugiat, quis dolores?
                        </Typography>
                    </CardContent>
                </Card>
            </div>
            <div style={{ width: '30%', border: '1px solid black', padding: '10px' }}>
                <CardContent border='1px solid black'>
                    <Typography sx={{ fontSize: 14 }} color="text.secondary" gutterBottom>
                        Table Reservastion deal for
                    </Typography>
                    <div style={{ display: 'flex', justifyContent: 'space-between' }}>
                        <input style={{ padding: '10px', borderRadius: '10px' }}
                            type="date"
                            id="datePicker"
                            value={selectedDate}
                            onChange={(e) => setSelectedDate(e.target.value)}
                        />
                        <FormControl style={{ width: "150px" }} >
                            <InputLabel id="demo-simple-select-label">Party Size</InputLabel>
                            <Select
                                labelId="demo-simple-select-label"
                                id="demo-simple-select"
                                value={selectedData.partySize}
                                label="Party Size"
                                name="partySize"
                                onChange={handleChange}
                            >
                                <MenuItem value={1}>One</MenuItem>
                                <MenuItem value={2}>Two</MenuItem>
                                <MenuItem value={3}>Three</MenuItem>
                                <MenuItem value={4}>Four</MenuItem>
                            </Select>
                        </FormControl>
                    </div>
                </CardContent>
                <Stack direction='row' spacing={1}>
                    {options.map(item => (
                        <Chip key={item.id} label={item.time} component="a" href="#basic-chip" clickable />
                    ))}
                </Stack>
                <Card sx={{ maxWidth: 345, margin: 'auto', marginTop: '10px' }}>
                    <CardActionArea>
                        <CardContent>
                            <Typography gutterBottom variant="h5" component="div">
                                Offers
                            </Typography>
                            <Typography variant="body2" color="text.secondary">
                                Lizards are a widespread group of squamate reptiles, with over 6,000
                                species, ranging across all continents except Antarctica
                            </Typography>
                        </CardContent>
                        <Button onClick={handleBookNow} variant="contained" margin='auto' size='large'>Book Now</Button>
                    </CardActionArea>
                </Card>
            </div>
        </div>
    )
}
export default TabledDetails