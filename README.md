trigger.io-forge-share-plugin
=============================

Dead simple android share plugin for trigger.io forge

Just call this from javascript:

```
forge.internal.call(
    'share.text',
    {sharedText: 'Check it out', sharedSubject: 'Amazing'},
    function () {},
    function (e) { alert('Error: '+e.message)}
);
```

More information can be found at http://docs.trigger.io/en/v1.4/modules/native/index.html
