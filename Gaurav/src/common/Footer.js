import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import { Typography, Link, Container } from '@material-ui/core';

const useStyles = makeStyles((theme) => ({
  footer: {
    padding: theme.spacing(2),
    marginTop: 'auto',
    backgroundColor:
      theme.palette.type === 'light' ? theme.palette.grey[200] : theme.palette.grey[800],
  },
}));

const Footer = () => {
  const classes = useStyles();

  return (
    <footer className={classes.footer}>
      <Container maxWidth="sm">
        <Typography variant="body1" align="center">
          © {new Date().getFullYear()} Reservo. All rights reserved.
        </Typography>
        <Typography variant="body2" color="textSecondary" align="center">
          Built with{' '}
          <Link color="inherit" href="https://material-ui.com/">
            Material-UI
          </Link>{' '}
          and React
        </Typography>
      </Container>
    </footer>
  );
};

export default Footer;
