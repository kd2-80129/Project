import { Button, Card, CardActionArea, CardContent, InputLabel, MenuItem, Select, TextField, Typography } from '@mui/material';
import Autocomplete from "@mui/material/Autocomplete";
import React, { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom'

const SignUp = () => {
    const [signUpData, setSignUpData] = useState({
        firstName: '',
        lastName: '',
        email: '',
        mobileNo: '',
        password: '',
        confirmPassword: '',
        address: '',
        userRole: ''
    });
    const [isDisable, setIsDisable] = useState(true);

    const navigate = useNavigate();

    const handleOnChange = (e) => {
        console.log("THis", e.target.value);
        setSignUpData({
            ...signUpData,
            [e.target.name]: e.target.value,
        });
    };

    const handleSubmit = async (e) => {
        // Integrate Api here
        e.preventDefault();
        try {
            const response = await fetch('http://127.0.0.1:8080/user/signup', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                    // Add any other headers if needed
                },
                body: JSON.stringify(signUpData),
            });

            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            resetForm();
            navigate('/login')
            // Handle successful response here
            // const responseData = await response.json();
            // console.log(responseData);
        } catch (error) {
            console.error('Error:', error);
        }

        console.log(signUpData);
    };

    const resetForm = () => {
        setSignUpData({
            firstName: '',
            lastName: '',
            email: '',
            mobileNo: '',
            password: '',
            confirmPassword: '',
            address: '',
            userRole: null
        });
    };

    useEffect(() => {
        // Ensure all required fields are filled, including `userType`
        setIsDisable(
            signUpData.firstName === '' ||
            signUpData.lastName === '' ||
            signUpData.confirmPassword === '' ||
            signUpData.email === '' ||
            signUpData.mobileNo === '' ||
            signUpData.password === '' ||
            signUpData.address === '' ||
            signUpData.userRole === ''
        );
    }, [signUpData.firstName,
    signUpData.lastName,
    signUpData.confirmPassword,
    signUpData.email,
    signUpData.mobileNo,
    signUpData.password,
    signUpData.address,
    signUpData.userRole]);

    const allUsers = [
        { label: "Admin", value: "ROLE_ADMIN" },
        { label: "Customer", value: "ROLE_CUSTOMER" },
        { label: "Owner", value: "ROLE_OWNER" }
    ];

    return (
        <Card sx={{ maxWidth: 600 }}>
            <CardActionArea>
                <CardContent>
                    <Typography gutterBottom variant="h5" component="div">
                        SignUp
                    </Typography>

                    <TextField style={{ width: "100%", marginBottom: '5px' }}
                        id="outlined-multiline-flexible"
                        label="First Name"
                        multiline
                        maxRows={4}
                        name='firstName'
                        value={signUpData.firstName}
                        onChange={(e) => handleOnChange(e)}
                    />
                    <TextField style={{ width: "100%", marginBottom: '5px' }}
                        id="outlined-multiline-flexible"
                        label="Last Name"
                        multiline
                        maxRows={4}
                        name='lastName'
                        value={signUpData.lastName}
                        onChange={(e) => handleOnChange(e)}

                    />
                    <TextField style={{ width: "100%", marginBottom: '5px' }}
                        id="outlined-multiline-flexible"
                        label="Email"
                        multiline
                        maxRows={4}
                        name='email'
                        value={signUpData.email}
                        onChange={(e) => handleOnChange(e)}
                    />
                    <TextField style={{ width: "100%", marginBottom: '5px' }}
                        id="outlined-multiline-flexible"
                        label="Mobile No."
                        multiline
                        maxRows={4}
                        name='mobileNo'
                        value={signUpData.mobileNo}
                        onChange={(e) => handleOnChange(e)}
                    />
                    <TextField style={{ width: "100%", marginBottom: '5px' }}
                        id="outlined-multiline-flexible"
                        label="Password"
                        multiline
                        maxRows={4}
                        name='password'
                        value={signUpData.password}
                        onChange={(e) => handleOnChange(e)}
                    />
                    <TextField style={{ width: "100%", marginBottom: '5px' }}
                        id="outlined-multiline-flexible"
                        label="Re-Enter Password"
                        multiline
                        maxRows={4}
                        name='confirmPassword'
                        value={signUpData.confirmPassword}
                        onChange={(e) => handleOnChange(e)}
                    />
                    <TextField style={{ width: "100%", marginBottom: '5px' }}
                        id="outlined-multiline-flexible"
                        label="Address"
                        multiline
                        maxRows={4}
                        name='address'
                        value={signUpData.address}
                        onChange={(e) => handleOnChange(e)}
                    />
                    <InputLabel id="demo-simple-select-label">Role</InputLabel>

                    <Select
                        sx={{ width: '100px' }}
                        labelId="demo-simple-select-label"
                        id="demo-simple-select"
                        value={signUpData.userRole}
                        label="Role"
                        name='userRole'
                        onChange={(e) => handleOnChange(e)}
                    >
                        {allUsers.map((item, index) => (
                            <MenuItem key={index} value={item.value}>{item.label}</MenuItem>
                        ))}
                        
                    </Select>
                    <br />
                    <Button disabled={isDisable} variant="contained" onClick={handleSubmit}>Submit</Button>
                </CardContent>
            </CardActionArea>
        </Card>
    )
};

export default SignUp;