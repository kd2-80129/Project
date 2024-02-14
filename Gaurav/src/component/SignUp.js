import { Button, Card, CardActionArea, CardContent, TextField, Typography } from '@mui/material'
import React, { useEffect, useState } from 'react'

const SignUp = () => {
    const [signUpData, setSignUpData] = useState({
        name: '',
        email: '',
        mobile: '',
        password: '',
        confirmPassword: ''
    });
    const [isDisable, setIsDisable] = useState(true)
    const handleOnChange = (e) => {
        console.log("THis", e.target.value);
        setSignUpData({
            ...signUpData,
            [e.target.name]: e.target.value,
        });
    }
    const handleSubmit = () => {
        // Integrate Api here 
        console.log(signUpData);
        resetForm()
    }
    const resetForm = () => {
        setSignUpData({
            name: '',
            email: '',
            mobile: '',
            password: '',
            confirmPassword: ''
        })
    }

    useEffect(() => {
        setIsDisable(signUpData.name === '' ||
            signUpData.confirmPassword === '' ||
            signUpData.email === '' ||
            signUpData.mobile === '' ||
            signUpData.password === '')
    }, [signUpData.name,
    signUpData.confirmPassword,
    signUpData.email,
    signUpData.mobile,
    signUpData.password])
    return (
        <Card sx={{ maxWidth: 600 }}>
            <CardActionArea>
                <CardContent>
                    <Typography gutterBottom variant="h5" component="div">
                        SignUp
                    </Typography>
                    <TextField style={{ width: "100%", marginBottom: '5px' }}
                        id="outlined-multiline-flexible"
                        label="Name"
                        multiline
                        maxRows={4}
                        name='name'
                        value={signUpData.name}
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
                        name='mobile'
                        value={signUpData.mobile}
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
                    <Button disabled={isDisable} variant="contained" onClick={handleSubmit}>Submit</Button>
                </CardContent>
            </CardActionArea>
        </Card>
    )
}

export default SignUp